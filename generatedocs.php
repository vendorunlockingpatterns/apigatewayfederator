<?php
define('CLASSES_ROOT_DIR','impl/target/classes/org/vendorunlockingpatterns/apigatewayfederator');
define('DS',DIRECTORY_SEPARATOR);
define('DOTCLASS','.class');
define('DOCS_DIR',__DIR__ . DS . 'docs');
define('DIAGRAM_PUML','.diagram.puml');

/**
 * Script for generating documentation according to the PlantUML format
 * @author Flávio Gomes da Silva Lisboa <flavio.lisboa@fgsl.eti.br>
 */

//=============================== FUNCTIONS ===================================
function removeWildcards(array &$dir): void
{
    unset($dir[0]);
    unset($dir[1]);
}

function generateDiagramFiles($dir,$path): void
{
    echo "\nGenerating PUML files from classes...";
    $path = (strrev($path)[0] == DS ? $path : $path . DS);
    echo "$path\n";
    foreach($dir as $target){
        if (str_contains($target,DOTCLASS)){
            $className = str_replace(DOTCLASS,'',$target);
            generateDiagramFile($path . $target, $className);
        } else {
            $subdir = scandir($path . $target);
            removeWildcards($subdir);
            generateDiagramFiles($subdir, $path . $target);
        }
    }
}

function generateDiagramFile(string $path, string $className): void
{
    echo "\nTrying to generate docs/$className.puml from $path...\n";
    system("genuml generate $path > docs/$className.puml");
}

function fixPUMLSyntax(string $uml): string
{
    $uml = str_replace('<I ','<I>',$uml);
    $uml = str_replace("<I\n",'<I>',$uml);
    $uml = str_replace('<T ','<T>',$uml);
    $uml = str_replace("<T\n",'<T>',$uml);
    $uml = str_replace('<C ','<C>',$uml);
    $uml = str_replace("<C\n",'<C>',$uml);
    return str_replace(" --",'',$uml);
}

function normalizePackageName(string $package): string
{

    $package = str_replace('<I','',$package);
    $package = str_replace('<T','',$package);
    $package = str_replace('<C','',$package);
    $package = str_replace('>','',$package);
    return trim(str_replace(' --','',$package));
}

function gatherDiagramsByPackage(): void
{
    $docsdir = scandir(DOCS_DIR);
    removeWildcards($docsdir);
    echo "\nGathering diagrams by package...\n";
    $previouspackage = '';
    $currentpackage = '';
    foreach($docsdir as $umlfile)
    {
        if (str_contains($umlfile,'.puml')){
            $uml = file_get_contents(DOCS_DIR . DS . $umlfile);
            $uml = fixPUMLSyntax($uml);
            $lines = explode("\n",$uml);
            $currentpackage = trim($lines[1] ?? 'default');
            if (empty($currentpackage) || str_contains($currentpackage,'@')
            || $currentpackage == 'diagram'){
                continue;
            }
            if (str_contains($currentpackage,'<')){
                $tokens = explode('.',$currentpackage);
                unset($tokens[count($tokens)-1]);
                $currentpackage = implode('.',$tokens);
            }
            $currentpackage = normalizePackageName($currentpackage);
            if ($currentpackage != $previouspackage){
                if (!file_exists(DOCS_DIR . DS . $currentpackage . DIAGRAM_PUML)){
                    $handle = fopen(DOCS_DIR . DS . $currentpackage . DIAGRAM_PUML, "w");
                    fclose($handle);
                }
                $previouspackage = $currentpackage;
            }
            $text = file_get_contents(DOCS_DIR . DS . $currentpackage . DIAGRAM_PUML);
            file_put_contents(DOCS_DIR . DS . $currentpackage . DIAGRAM_PUML, $text . $uml);
            $removeCommand = 'rm ' . DOCS_DIR . DS . $umlfile;
            echo "\n$removeCommand\n";
            system($removeCommand);
        }
    }
}

function generateImages(): void
{
    $pumlfiles = scandir(DOCS_DIR . DS);
    removeWildcards($pumlfiles);
    foreach($pumlfiles as $file){
        if (str_contains($file,'.puml')){
            $text = file_get_contents(DOCS_DIR . DS . $file);
            $text = "@startuml\n" . $text . "\n@enduml"; // add diagram delimiters
            file_put_contents(DOCS_DIR . DS . $file, $text);
            echo "\nGenerating image for $file...\n";
            $imageName = str_replace('.puml','',$file);
            system("java -jar plantuml.jar docs/$file > docs/$imageName.png");
        }
    }
}

function createREADMEfile(): void
{
    $handle = fopen(DOCS_DIR . DS . 'README.md', "w");
    fclose($handle);
    
    $text = <<<BLOCK
    # Class diagrams of the API Gateway Federator pattern
    
    BLOCK;
    file_put_contents(DOCS_DIR . DS . 'README.md', $text);
    
    @system('rm ' . DOCS_DIR . DS . 'default.diagram.*');
    
    $pngfiles = scandir(DOCS_DIR . DS);
    removeWildcards($pngfiles);
    foreach($pngfiles as $file){
        if (str_contains($file,'.png')){
            $text = file_get_contents(DOCS_DIR . DS . 'README.md');
            $package = str_replace('.diagram.png','',$file);
            $text = $text . "\n" . "## $package\n![$package]($file)\n";
            file_put_contents(DOCS_DIR . DS . 'README.md', $text);
        }
    }
}

//================================== MAIN =====================================
$startime = microtime(true);

@system('rm ' .  DOCS_DIR . DS . '*.puml');
@system('rm ' . DOCS_DIR . DS. '*.png');
$agfdir = scandir(__DIR__ . DS . CLASSES_ROOT_DIR);
removeWildcards($agfdir);

generateDiagramFiles($agfdir, __DIR__ . DS . CLASSES_ROOT_DIR);

gatherDiagramsByPackage();

generateImages();

createREADMEfile();

$elapsedtime = microtime(true) - $startime;

echo "\n$elapsedtime seconds elapsed\n";
